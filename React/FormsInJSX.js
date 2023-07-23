const nameRef = React.createRef();
const marksRef = React.createRef();
let nameAndMarksArray = [];

function handleSubmit(event) {
    event.preventDefault();
    let nameValue = nameRef.current.value;
    let marksValue = marksRef.current.value;
    if (nameValue !== "" && marksValue !== "") {
        nameAndMarksArray.unshift(
            <>
                <td>{nameRef.current.value}</td>
                <td>{marksRef.current.value}</td>
            </>
        )
        nameRef.current.value = "";
        marksRef.current.value = "";
        rootElement.render(<App />)
    }
}

const Form = () => (
    <form onSubmit={handleSubmit}>
        <input placeholder="Name" ref={nameRef} />
        <input placeholder="Marks" ref={marksRef} />
        <button>Submit</button>
    </form>
);

const Result = () => (
    <>
        <table border="1">
            <thead>
                <tr>
                    <th>Student's Name</th>
                    <th>Marks</th>
                </tr>
            </thead>
            <tbody>
                {nameAndMarksArray.map((entry, index) => (
                    <tr key={index}>{entry}</tr>
                ))}
            </tbody>
        </table>
    </>
);

const App = () => (
    <>
        <h1>Student's form</h1>
        <Form />
        <br />
        <br />
        <Result />
    </>
);

const rootElement = ReactDOM.createRoot(document.getElementById("root"));
rootElement.render(<App />);