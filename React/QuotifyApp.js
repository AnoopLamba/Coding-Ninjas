const nameRef = React.createRef();
const quoteRef = React.createRef();
const quotes = [];

const clearInputs = () => {
    nameRef.current.value = "";
    quoteRef.current.value = "";
};


function handleQuote(event) {
    let nameValue = nameRef.current.value.trim();
    let quoteValue = quoteRef.current.value.trim();
    if (event.key === "Enter" && nameValue !== "" && quoteValue !== "") {
        quotes.unshift(
            <>
                <i>"{quoteValue}"</i>
                <b>~ {nameValue}</b>
            </>
        )
        clearInputs();
        rootElement.render(<App />);
    }
}

const App = () => (
    <div className="App">
        <h2>Quotify</h2>
        <input placeholder="Name" ref={nameRef} onKeyPress={handleQuote} required />
        <input placeholder="Quote" ref={quoteRef} onKeyPress={handleQuote} required />
        <div className="quotes">
            {quotes.map((q, i) => (
                <div key={i}>
                    {q}
                </div>
            ))}
        </div>
    </div>
);

const rootElement = ReactDOM.createRoot(document.getElementById("root"));
rootElement.render(<App />);