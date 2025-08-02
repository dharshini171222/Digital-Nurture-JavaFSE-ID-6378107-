import React from 'react';

class Cart extends React.Component {
  render() {
    const { itemname, price } = this.props;
    return (
      <div style={{ border: '1px solid #ccc', margin: '10px', padding: '10px' }}>
        <h3>{itemname}</h3>
        <p>Price: ₹{price}</p>
      </div>
    );
  }
}

export default Cart;
