package com.mentes_innovadoras.gift4you.exception.inventory_item;

import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import org.springframework.http.HttpStatus;

public class InsufficientStockException extends ArchitectureException {
    public InsufficientStockException(String itemName, int availableQuantity, int requested) {
        super();
        this.code = ResponseConstant.Code.architecture;
        this.msg = "Not enough stock for item: " + itemName + ". Available: " + availableQuantity + ", Requested: " + requested;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
