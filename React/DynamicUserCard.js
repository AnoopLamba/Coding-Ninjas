let myName;
let email;
let about;

const Card = () => (
    <div className="card">
        <h3>Name: {myName}</h3>
        <p>Email: {email}</p>
        <p>About: {about}</p>
    </div>
);

function nameChange(event) {
    myName = event.target.value;
    rootElement.render(<App/>);
}
function emailChange(event) {
    email = event.target.value;
    rootElement.render(<App/>);
}
function aboutChange(event) {
    about = event.target.value;
    rootElement.render(<App/>);
}

const App = () => (
    <>
        <Card/>
        <div className="App">
            <div className="inputs">
                <input placeholder="Name" onChange={nameChange}/>
                <input type="email" placeholder="Email" onChange={emailChange}/>
                <textarea placeholder="About" onChange={aboutChange}></textarea>
            </div>
        </div>
    </>
);

const rootElement = ReactDOM.createRoot(document.getElementById("root"));
rootElement.render(<App />);