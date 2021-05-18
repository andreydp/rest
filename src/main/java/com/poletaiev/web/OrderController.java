package com.poletaiev.web;

import com.poletaiev.Constants;
import com.poletaiev.core.model.APIError;
import com.poletaiev.core.model.Order;
import com.poletaiev.core.model.OrderRepository;
import com.poletaiev.core.model.dto.OrderDto;
import com.poletaiev.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order")
public final class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Produces("application/json")
    /*
      @param id must be numeric only
     * Error object is serialized if any exception happens
     */
    public String getOrder(@PathVariable("id") String id) {

        long orderId;
        Order order;
        try {
            orderId = Long.parseLong(id);
            order = orderService.getOrderById(orderId);
        }
        catch (NumberFormatException e) {
            return new APIError(Constants.ERR_CODE_INVALID_ORDER_ID_FORMAT, "Order ID must be numeric, but [" + id + "] was given").toJson();
        }
        catch (DataAccessException e)
        {
            return new APIError(Constants.ERR_CODE_DB_ERROR, "Database error. " + e.getMessage()).toJson();
        }
        catch (Exception e) {
            return new APIError(Constants.ERR_CODE_UNDEFINED, "Undefined error").toJson();
        }
        if (order == null) {
            return new APIError(Constants.ERR_CODE_ORDER_NOT_FOUND, "Order with id [" + id + "] was not found").toJson();
        }
        return orderService.toJson(order);
    }

    @PostMapping("/postOrder")
    public void postOrder(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setAgent(orderDto.getAgent());
        order.setAmount(orderDto.getAmount());
        order.setApproved(orderDto.isApproved());
        order.setCustomer(orderDto.getCustomer());
        order.setOrderDate(orderDto.getOrderDate());
        orderRepository.save(order);
    }
}

