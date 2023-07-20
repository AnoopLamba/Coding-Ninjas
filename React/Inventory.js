function App() {
    const itemsSold = [
        { id: 1, name: "iPhone 14", price: 1200, qty: 22 },
        { id: 2, name: "iPad Pro", price: 800, qty: 18 },
        { id: 3, name: "Macbook Air", price: 1500, qty: 7 },
        { id: 4, name: "Samsung S23", price: 1100, qty: 16 },
        { id: 5, name: "Dell Inspiron 5590", price: 1200, qty: 5 }
      ];

    let initialValue = 0;
    let totalRevenue = itemsSold.reduce((accumulator, currentValue) => {
        accumulator += currentValue.price;
        return accumulator;
    }, initialValue);


      return (
        <>
          <h1>Record of sold items</h1>
          <table border="1px">
          <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Selling Price</th>
                <th>Quantity</th>
            </tr>
          </thead>
          <tbody>
            {itemsSold.map((item, index)=>(
                <tr key={index}>
                    <td>{item.id}</td>
                    <td>{item.name}</td>
                    <td>{item.price}</td>
                    <td>{item.qty}</td>
                </tr>
            ))}
          </tbody>
          <tfoot>
            <tr>
                <td>Total Revenue</td>
                <td colSpan="3">${totalRevenue}</td>
            </tr>
          </tfoot>
          </table>
        </>
      );
}

const rootElement = ReactDOM.createRoot(document.getElementById("root"));
rootElement.render(<App/>);