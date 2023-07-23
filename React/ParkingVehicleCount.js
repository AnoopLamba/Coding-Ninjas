let vehicles = {
    car: 0,
    bike: 0,
    scooty: 0,
    bicycle: 0
};

function vehicleHandler(vehicle, num) {
    let parsedNum = parseInt(num, 10);
    if(parsedNum < 0 && vehicles[vehicle] > 0) {
        vehicles[vehicle]--;
    } else if(parsedNum > 0) {
        vehicles[vehicle]++;
    }
    rootElement.render(<App />)
}

const VehicleItem = ({vehicleName, vehicleKey})=>(
    <li>
        <p>
            <b>{vehicleName}: {vehicles[vehicleKey]}</b> &emsp;
            <button onClick={()=>vehicleHandler(vehicleKey,"+1")}>Increase</button> &nbsp;&nbsp;
            <button onClick={()=> vehicleHandler(vehicleKey, "-1")}>Decrease</button>
        </p>
    </li>
)

const App = () => (
    <>
        <p>List of all the vehicles count in the parking.</p>
        <ol>
            <VehicleItem vehicleName="Car" vehicleKey="car" />
            <VehicleItem vehicleName="Bike" vehicleKey="bike" />
            <VehicleItem vehicleName="Scooty" vehicleKey="scooty" />
            <VehicleItem vehicleName="Bicycle" vehicleKey="bicycle" />
        </ol>
    </>
);

const rootElement = ReactDOM.createRoot(document.getElementById("root"));
rootElement.render(<App />);