const timeTable = {
    Monday: {
        9: {
            subject: "Maths",
            teacher: "Brijesh Mishra",
            time: "1 hour"
        },
        10: {
            subject: "Physics",
            teacher: "Sumit Yadav",
            time: "1 hour"
        },
        11: {
            subject: "Chemistry",
            teacher: "Vedanti Joshi",
            time: "1 hour"
        },
        13: {
            subject: "English Litrature",
            teacher: "Mayur Pandey",
            time: "1 hour"
        },
        14: {
            subject: "Hindi Vyakaran",
            teacher: "Sony Desai",
            time: "1 hour"
        },
        15: {
            subject: "PT",
            teacher: "Sonu Tyagi",
            time: "1 hour"
        }
    },
    Tuesday: {
        9: {
            subject: "Physics",
            teacher: "Sumit Yadav",
            time: "1 hour"
        },
        10: {
            subject: "Hindi Sahitya",
            teacher: "Ramesh Jha",
            time: "1 hour"
        },
        11: {
            subject: "Environtal Studies",
            teacher: "Rakesh Prakash",
            time: "1 hour"
        },
        13: {
            subject: "Biology",
            teacher: "Kuldeep Narayan",
            time: "1 hour"
        },
        14: {
            subject: "Maths",
            teacher: "Brijesh Mishra",
            time: "1 hour"
        },
        15: {
            subject: "Physics Practical",
            teacher: "Sumit Yadav",
            time: "1 hour"
        }
    },
    Wednesday: {
        9: {
            subject: "Chemistry",
            teacher: "Vedanti Joshi",
            time: "1 hour"
        },
        10: {
            subject: "English Grammar",
            teacher: "Aditi Upasane",
            time: "1 hour"
        },
        11: {
            subject: "Maths",
            teacher: "Brijesh Mishra",
            time: "1 hour"
        },
        13: {
            subject: "English Litrature",
            teacher: "Mayur Pandey",
            time: "1 hour"
        },
        14: {
            subject: "Physics",
            teacher: "Sumit Yadav",
            time: "1 hour"
        },
        15: {
            subject: "Chemistry Practical",
            teacher: "Vedanti Joshi",
            time: "1 hour"
        }
    },
    Thursday: {
        9: {
            subject: "Biology",
            teacher: "Kuldeep Narayan",
            time: "1 hour"
        },
        10: {
            subject: "Hindi Sahitya",
            teacher: "Ramesh Jha",
            time: "1 hour"
        },
        11: {
            subject: "Chemistry",
            teacher: "Vedanti Joshi",
            time: "1 hour"
        },
        13: {
            subject: "Maths",
            teacher: "Brijesh Mishra",
            time: "1 hour"
        },
        14: {
            subject: "Physics",
            teacher: "Sumit Yadav",
            time: "1 hour"
        },
        15: {
            subject: "Biology Practical",
            teacher: "Kuldeep Narayan",
            time: "1 hour"
        }
    },
    Friday: {
        9: {
            subject: "English Litrature",
            teacher: "Mayur Pandey",
            time: "1 hour"
        },
        10: {
            subject: "Hindi Sahitya",
            teacher: "Ramesh Jha",
            time: "1 hour"
        },
        11: {
            subject: "English Grammar",
            teacher: "Aditi Upasane",
            time: "1 hour"
        },
        13: {
            subject: "Biology",
            teacher: "Kuldeep Narayan",
            time: "1 hour"
        },
        14: {
            subject: "Hindi Vyakaran",
            teacher: "Sony Desai",
            time: "1 hour"
        },
        15: {
            subject: "PT",
            teacher: "Sonu Tyagi",
            time: "1 hour"
        }
    }
};

const dayArray = Object.keys(timeTable);
const timeArray = Object.keys(timeTable[dayArray[0]]);

const App = () => (
    <table border="1">
        <caption>School time-table of a class 12th Student.</caption>
        <thead>
            <tr>
                <th></th>
                {timeArray.map((time) => {
                    const currentTime = parseInt(time, 10);
                    const nextTime = currentTime + 1;
                    const formattedCurrentTime = currentTime <= 12 ? currentTime : currentTime - 12;
                    const formattedNextTime = nextTime <= 12 ? nextTime : nextTime - 12;

                    return (
                        <React.Fragment key={time}>
                            <th>
                                {formattedCurrentTime}{currentTime < 12 ? "am" : "pm"}-{formattedNextTime}{nextTime < 12 ? "am" : "pm"}
                            </th>
                            {currentTime === 11 && <th>12pm-1pm</th>}
                        </React.Fragment>
                    )
                })}

            </tr>
        </thead>
        <tbody>
            {dayArray.map((day) => (
                <tr key={day}>
                    <th>{day}</th>
                    {timeArray.map((time) => (
                        <React.Fragment key={time}>
                            <td>{timeTable[day][time].subject} - {timeTable[day][time].teacher}</td>
                            {time === "11" && <td>Break</td>}
                        </React.Fragment>
                    ))}
                </tr>
            ))}
        </tbody>
    </table>
);

const rootElement = ReactDOM.createRoot(document.getElementById("root"));
rootElement.render(<App />);