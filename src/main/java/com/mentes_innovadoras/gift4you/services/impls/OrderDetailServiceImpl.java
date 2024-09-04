package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import com.mentes_innovadoras.gift4you.entity.Order;
import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import com.mentes_innovadoras.gift4you.exception.common.InvalidParamException;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.account.UserNotFoundException;
import com.mentes_innovadoras.gift4you.mapper.OrderDetailMapper;
import com.mentes_innovadoras.gift4you.payload.reponse.OrderDetailResponse;
import com.mentes_innovadoras.gift4you.payload.request.OrderDetailRequest;
import com.mentes_innovadoras.gift4you.repository.OrderDetailRepository;
import com.mentes_innovadoras.gift4you.repository.OrderRepository;
import com.mentes_innovadoras.gift4you.services.interfaces.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
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
        if (orderDetailResponse == null) throw new UserNotFoundException();
        return orderDetailResponse;
    }

    @Override
    public OrderDetailResponse createOrderDetail(OrderDetailRequest orderDetailRequest) throws ArchitectureException {
        OrderDetail newOrderDetail = orderDetailMapper.toOrderDetailEntity(orderDetailRequest);
        Order order = orderRepository.findById(orderDetailRequest.getOrder().getId()).orElse(null);
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
        if (orderDetail == null) throw new UserNotFoundException();
        orderDetail.setCreateAt(new Date());
        orderDetail.setUpdateAt(new Date());
        orderDetail.setDescription(orderDetailRequest.getDescription());
        orderDetail.setPrice(orderDetailRequest.getPrice());
        orderDetail.setQuantity(orderDetailRequest.getQuantity());
        return orderDetailMapper.toOrderDetailResponse(orderDetailRepository.save(orderDetail));
    }
}
