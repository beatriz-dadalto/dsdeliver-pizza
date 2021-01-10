import React from 'react';
import { checkIsSelected } from './helpers';
import ProductCard from './ProductCard';
import { Product } from './types';

type Props = {
  products: Product[];
  onSelectProduct: (product: Product) => void;
  selectedProducts: Product[];
};

function ProductsList({ products, onSelectProduct, selectedProducts }: Props) {
  return (
    <div className="orders-list-container">
      <div className="orders-list-items">
        {products.map(product => (
          <ProductCard
            key={product.id}
            product={product}
            onSelectProduct={onSelectProduct}
            isSelected={checkIsSelected(selectedProducts, product)}
          />
        ))}
      </div>
    </div>
  );
}

export default ProductsList;
