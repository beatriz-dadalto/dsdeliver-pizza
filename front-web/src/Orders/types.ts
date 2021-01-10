// model de um produto
// lá no java tem a classe Product no package entities

export type Product = {
  id: number;
  name: string;
  price: number;
  description: string;
  imageUri: string;
};

export type OrderLocationData = {
  latitude: number;
  longitude: number;
  address: string;
};

type ProductId = {
  id: number;
};

// enviar para o backend para criar o pedido
export type OrderPayload = {
  products: ProductId[];
} & OrderLocationData;