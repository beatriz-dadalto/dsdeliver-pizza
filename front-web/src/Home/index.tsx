import React from 'react';
import './styles.css';
import { ReactComponent as MainImage } from './main.svg';
import Footer from '../Footer';

function Home() {
  return (
    <>
      <div className="home-container">
        <div className="home-content">
          <div className="home-actions">
            <h1 className="home-title">
              Faça seu pedido <br /> que entregamos <br /> pra você!!!
            </h1>
            <h3 className="home-sub-title">
              Escolha o seu pedido e em poucos minutos <br /> levaremoss na sua
              porta
            </h3>
            <a href="#link" className="home-btn-order">
              FAZER PEDIDO
            </a>
          </div>
          <div className="home-image">
            <MainImage />
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default Home;
