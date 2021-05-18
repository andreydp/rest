package com.poletaiev.web;

import com.poletaiev.core.model.APIException;
import com.poletaiev.core.model.Order;
import com.poletaiev.core.model.OrderRepository;
import com.poletaiev.core.model.dto.OrderDto;
import com.poletaiev.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;

import static com.poletaiev.Constants.ERR_CODE_INVALID_ORDER_ID_FORMAT;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order")
public final class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping("")
    @Produces("application/json")
    public List<Order> getOrderAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Produces("application/json")
    /*
      @param id must be numeric only
     * Error object is serialized if any exception happens
     */
    public Object getOrder(@PathVariable("id") String id) {
        long orderId;
        Order order = null;
            try {
                orderId = Long.parseLong(id);
                order = orderService.getOrderById(orderId);
            }
            catch (APIException ex)
            {
                return ex.toString();
            }
            catch (NumberFormatException ex)
            {
                return new APIException(ERR_CODE_INVALID_ORDER_ID_FORMAT, "orderId '" + id + "' is not numeric").toString();
            }
        return order == null ? "" : order;
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

