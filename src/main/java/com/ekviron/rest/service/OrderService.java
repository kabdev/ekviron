package com.ekviron.rest.service;

import com.ekviron.rest.exception.EntityAlreadyExistException;
import com.ekviron.rest.exception.EntityNotFoundException;
import com.ekviron.rest.model.Order;
import com.ekviron.rest.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Order.class, "id", id.toString()));
    }

    public Order create(Order order) {
        try {
            return orderRepository.save(order);
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyExistException(Order.class);
        }
    }

    public void delete(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            // maybe idempotent?
            throw new EntityNotFoundException(Order.class, "id", id.toString());
        }
    }

}
