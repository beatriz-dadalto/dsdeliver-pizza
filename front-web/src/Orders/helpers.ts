import { Product } from "./types";

export function checkIsSelected(selectedProducts: Product[], product: Product) {
  return selectedProducts.some(item => item.id === product.id);
}

// formatar o valor da pizza que da vem API
export function formatPrice(price: number) {
  const formatter = new Intl.NumberFormat('pt-BR', {
    style: 'currency',
    currency: 'BRL',
    minimumFractionDigits: 2
  });

  return formatter.format(price);
}