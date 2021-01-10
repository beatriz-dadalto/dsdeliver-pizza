import React from 'react';
import { formatPrice } from './helpers';

type Props = {
  amount: number;
  totalPrice: number;
  onSubmit: () => void;
};

function OrderSummary({ amount, totalPrice, onSubmit }: Props) {
  return (
    <div className="order-summary-container">
      <div className="order-summary-content">
        <div>
          <span className="amount-selected-container">
            <strong className="amount-selected">{amount} </strong>
            PEDIDOS SECIONADOS
          </span>
          <span className="order-summary-total">
            <strong className="amount-selected">R$ {formatPrice(totalPrice)} </strong>
            VALOR TOTAL
          </span>
        </div>
        <button
          className="order-summary-make-order"
          onClick={onSubmit}
        >
          FAZER PEDIDO
        </button>
      </div>
    </div>
  );
}

export default OrderSummary;
