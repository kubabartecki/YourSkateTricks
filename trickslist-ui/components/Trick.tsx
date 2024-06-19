import React from "react";
import {Trick} from "../services/models";
interface TrickProps {
    trick: Trick
}
const Trick: React.FC<TrickProps> = ({trick}) => (
    <div>
        <div className="alert alert-primary" role="alert">
            <h5>
                {trick.name}
            </h5>
            <span>
                {trick.difficulty}
            </span>
        </div>
    </div>
)

export default Trick;
