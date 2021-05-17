package com.poletaiev.web;

import com.poletaiev.Constants;
import com.poletaiev.core.model.APIError;
import com.poletaiev.core.model.Order;
import com.poletaiev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;

@RestController
@RequestMapping("api/details")
public final class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

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
}

