package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.Order;
import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import com.mentes_innovadoras.gift4you.exception.account.OrderDetailNotFoundException;
import com.mentes_innovadoras.gift4you.exception.account.OrderNotFoundException;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.orderDetail.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.orderDetail.OrderDetailRequest;
import com.mentes_innovadoras.gift4you.repository.OrderDetailRepository;
import com.mentes_innovadoras.gift4you.repository.OrderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;
    private final OrderRepository orderRepository;
    @Override
    public Page<OrderDetailResponse> getOrderDetails(Pageable pageable) {
        return orderDetailRepository.findAll(pageable).map(orderDetailMapper::toOrderDetailResponse);
    }

    @Override
    public OrderDetailResponse getOrderDetailById(UUID id) throws ArchitectureException {
        if (id == null) throw new InvalidParamException();
        OrderDetailResponse orderDetailResponse = orderDetailRepository.findById(id).map(orderDetailMapper::toOrderDetailResponse).orElse(null);
        if (orderDetailResponse == null) throw new OrderDetailNotFoundException();
        return orderDetailResponse;
    }

    @Override
    public OrderDetailResponse createOrderDetail(OrderDetailRequest orderDetailRequest) throws ArchitectureException {
        Order order = orderRepository.findById(orderDetailRequest.getOrderId()).orElse(null);
        if (order == null) throw new OrderNotFoundException();
        OrderDetail newOrderDetail = orderDetailMapper.toOrderDetailEntity(orderDetailRequest);
        newOrderDetail.setId(UUID.randomUUID());
        newOrderDetail.setCreateAt(new Date());
        newOrderDetail.setUpdateAt(new Date());
        newOrderDetail.setDescription(orderDetailRequest.getDescription());
        newOrderDetail.setPrice(orderDetailRequest.getPrice());
        newOrderDetail.setQuantity(orderDetailRequest.getQuantity());
        newOrderDetail.setOrder(order);
        return orderDetailMapper.toOrderDetailResponse(orderDetailRepository.save(newOrderDetail));    }

    @Override
    public OrderDetailResponse updateOrderDetail(UUID id, OrderDetailRequest orderDetailRequest) throws ArchitectureException {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElse(null);
        if (orderDetail == null) throw new OrderDetailNotFoundException();
        orderDetail.setCreateAt(new Date());
        orderDetail.setUpdateAt(new Date());
        orderDetail.setDescription(orderDetailRequest.getDescription());
        orderDetail.setPrice(orderDetailRequest.getPrice());
        orderDetail.setQuantity(orderDetailRequest.getQuantity());
        return orderDetailMapper.toOrderDetailResponse(orderDetailRepository.save(orderDetail));
    }
}
