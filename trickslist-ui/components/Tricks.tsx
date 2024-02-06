import React from "react";
import {TricksResponse} from "../services/models";
import Trick from "./Trick";
import Pagination from "./Pagination";

interface TricksProps {
    tricks: TricksResponse
    query?: string
}
const Tricks: React.FC<TricksProps> = ({tricks, query})=> (
    <div>
        <Pagination tricks={tricks} query={query}/>
        {tricks.data.map(trick => <Trick key={trick.id} trick={trick}/>)}
    </div>
);

export default Tricks;
