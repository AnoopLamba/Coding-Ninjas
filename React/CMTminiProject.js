const capacity = 25;
let seatsLeft = 25;
let customers = [];
let guestCountRef = React.createRef();
let guestNameRef = React.createRef();
let phoneRef = React.createRef();

function refValueClear() {
    guestCountRef.current.value = "";
    guestNameRef.current.value = "";
    phoneRef.current.value = "";
}

function getCurrentTime() {
    const date = new Date();
    let hours = date.getHours();
    const minutes = date.getMinutes();
    const seconds = date.getSeconds();

    const ampm = hours >= 12 ? 'PM' : 'AM';
    hours = hours % 12 || hours;

    const formattedTime = `${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')} ${ampm}`;
    return formattedTime;
}

function removeEntry(index) {
    seatsLeft += parseInt(customers[index].count, 10);
    customers.splice(index, 1);
    rootElement.render(<App />);
}

function checkoutHandler(index) {
    customers[index].checkout = getCurrentTime();
    rootElement.render(<App />);
}

// Create form submit handler here
function onSubmitHandler(event) {
    event.preventDefault();
    if (seatsLeft > 0 && guestCountRef.current.value <= seatsLeft) {
        customers.unshift(
            {
                name: guestNameRef.current.value,
                phone: phoneRef.current.value,
                count: guestCountRef.current.value,
                checkin: getCurrentTime(),
                checkout: "-"
            }
        )
        seatsLeft -= guestCountRef.current.value;
        refValueClear();

        rootElement.render(<App />);
    }
}

const App = () => (
    <div className="App" style={{ textAlign: "center" }}>
        <div>
            <h2>Total Capacity: {capacity}</h2>
            <h2>Seats Left: {seatsLeft}</h2>
        </div>
        <form onSubmit={onSubmitHandler}>
            <input placeholder="Guests Count" ref={guestCountRef} required inputtype="number"/>
            <input placeholder="Primary Guest Name" ref={guestNameRef} required />
            <input placeholder="Phone Number" ref={phoneRef} required inputtype="number"/>
            <button>Add Entry</button>
        </form>

        <table border="1px" style={{ margin: "auto" }}>
            <thead>
                <tr>
                    <th>Count</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Check In</th>
                    <th>Check Out</th>
                    <th>Status</th>
                    <th>Remove Entry</th>
                </tr>
            </thead>
            <tbody>
                {customers.map((customer, index) => (
                    <tr key={index}>
                        <td>{customer.count}</td>
                        <td>{customer.name}</td>
                        <td>{customer.phone}</td>
                        <td>{customer.checkin}</td>
                        <td>{customer.checkout}</td>
                        <td onClick={customer.checkout === "-" ? () => checkoutHandler(index) : null} style={{cursor: "pointer"}}>
                            {customer.checkout === "-" ? "Click to Checkout" : "Served"}
                        </td>

                        <td onClick={() => removeEntry(index)} style={{cursor: "pointer"}}>Remove</td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>
);

const rootElement = ReactDOM.createRoot(document.getElementById("root"));
rootElement.render(<App />);