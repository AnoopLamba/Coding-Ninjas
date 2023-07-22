let visible = true;
const setShow = () => {
    if(visible) {
        visible = false;
    } else {
        visible = true;
    }
    rootElement.render(<App/>);
};

const App = () => (
    <>
        <h1>Coding Ninjas</h1>
        <button onClick={setShow}>{visible?"Hide element below":"Show element below"}</button>
        {visible && <p>Hello my fellow coder!</p>}
    </>
);

const rootElement = ReactDOM.createRoot(document.getElementById("root"));
rootElement.render(<App />);