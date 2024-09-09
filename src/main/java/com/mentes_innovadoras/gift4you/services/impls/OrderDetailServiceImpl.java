package com.mentes_innovadoras.gift4you.services.impls;

import com.mentes_innovadoras.gift4you.entity.Order;
import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import com.mentes_innovadoras.gift4you.exception.common.OrderDetailNotFoundException;
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
        return null;
    }

    @Override
    public OrderDetailResponse getOrderDetailById(UUID id) throws ArchitectureException {
        return null;
    }

    @Override
    public OrderDetailResponse createOrderDetail(OrderDetailRequest orderDetailRequest) throws ArchitectureException {
        return null;
    }

    @Override
    public OrderDetailResponse updateOrderDetail(UUID id, OrderDetailRequest orderDetailRequest) throws ArchitectureException {
        return null;
    }


}
