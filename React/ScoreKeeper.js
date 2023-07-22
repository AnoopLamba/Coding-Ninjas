let score = 0;
let wicket = 0;
let hit = 0;
let ballWiseScore = [];

const inputRef = React.createRef();

function addScore(num) {
    hit = num;
    rootElement.render(<App />);
}

function addWicket() {
    hit = "W";
    rootElement.render(<App />);
}

const ScoreButtons = () => (
    <div>
        <button onClick={()=> addScore(0)}>0</button>
        <button onClick={() => addScore(1)}>1</button>
        <button onClick={() => addScore(2)}>2</button>
        <button onClick={() => addScore(3)}>3</button>
        <button onClick={() => addScore(4)}>4</button>
        <button onClick={() => addScore(5)}>5</button>
        <button onClick={() => addScore(6)}>6</button>
        <button onClick={addWicket}>Wicket</button>
    </div>
)

const Result = () => (
    <div>
        {ballWiseScore.map((ball, index)=>(
            <React.Fragment key={index}>
                {index%6 === 0 && <br/>}
                {ball === "W" ? <span style={{ color: "red" }}>W</span> : ball === 0 ? "." : ball}
                &nbsp;&nbsp;&nbsp;
            </React.Fragment>
        ))}
    </div>
)

function handleSubmit(event) {
    event.preventDefault();
    ballWiseScore.unshift(
        <span>{hit}, {inputRef.current.value}</span>
    );
    hit = 0;
    inputRef.current.value = "";
    rootElement.render(<App />);
}

const Form = () => (
    <form onSubmit={handleSubmit}>
        <input value={hit} readOnly/>
        <input ref={inputRef} placeholder="Add a comment"/>
        <button>Submit</button>
    </form>
)

const App = () => (
    <>
        <h1>SCORE KEEPER</h1>
        <h2>Score {score}/{wicket}</h2>
        <ScoreButtons/>
        <br/>
        <Form/>
        <hr/>
        {ballWiseScore.map((ball, index)=>(
            <p key={index}>{ball}</p>
        ))}
    </>
)

const rootElement = ReactDOM.createRoot(document.getElementById("root"));
rootElement.render(<App />);