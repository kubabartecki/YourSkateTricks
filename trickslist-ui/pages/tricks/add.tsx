import type { NextPage } from 'next'
import React, {useState} from "react";
import {saveTrick} from "../../services/api";

const AddTrick: NextPage = () => {
    const [name, setName] = useState("");
    const [difficulty, setDifficulty] = useState("");
    const [message, setMessage] = useState<string|null>(null);

    const handleSubmit = async (e: React.SyntheticEvent) => {
        e.preventDefault();
        if(!difficulty) {
            alert("Please choose difficulty");
            return;
        }
        const payload = {
            name,
            difficulty
        }
        const response = await saveTrick(payload)
        console.log("SaveTrick response: ", response)
        setName("");
        setDifficulty("");
        setMessage("Trick saved successfully")
    }

    return (
        <div>
            <div className="card">
                <div className="card-header text-center">
                    <h2>Create New Trick</h2>
                </div>
                <div className="card-body">
                    <div className="card-text">
                        {message && <div className="alert alert-primary" role="alert">{message}</div> }
                        <form onSubmit={e => handleSubmit(e)}>
                            <div className="mb-3">
                                <label htmlFor="name" className="form-label">Name</label>
                                <input type="text" className="form-control" id="name"
                                       value={name} onChange={e => setName(e.target.value)}/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="difficulty" className="form-label">Difficulty</label>
                                <input type="text" className="form-control" id="difficulty"
                                       value={difficulty} onChange={e => setDifficulty(e.target.value)}/>
                            </div>
                            <button type="submit" className="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default AddTrick
