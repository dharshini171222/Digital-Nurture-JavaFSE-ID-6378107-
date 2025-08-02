import React from 'react';
import Cart from './Cart';

class OnlineShopping extends React.Component {
  render() {
    const items = [
      { itemname: 'Laptop', price: 75000 },
      { itemname: 'Smartphone', price: 30000 },
      { itemname: 'Headphones', price: 2500 },
      { itemname: 'Keyboard', price: 1500 },
      { itemname: 'Mouse', price: 800 },
    ];

    return (
      <div>
        <h2>Online Shopping Cart</h2>
        {items.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
