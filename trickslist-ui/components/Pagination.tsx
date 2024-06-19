import React from "react";
import Link from 'next/link'
import {TricksResponse} from "../services/models";

interface PaginationProps {
    tricks: TricksResponse
    query?: string
}

const Pagination: React.FC<PaginationProps> = ({tricks, query}) => {
    const path: string = "/tricks";
    const queryParams = (query === undefined || query === "")? {}: {query: query}
    const firstPage = {pathname: path, query: { page: 1 , ...queryParams}}
    const previousPage = {pathname: path, query: { page: tricks.currentPage - 1 , ...queryParams}}
    const nextPage = {pathname: path, query: { page: tricks.currentPage + 1 , ...queryParams}}
    const lastPage = {pathname: path, query: { page: tricks.totalPages , ...queryParams}}
    return(
        <div>
            <nav aria-label="Page navigation">
                <ul className="pagination justify-content-center">

                    <li className={"page-item " + (tricks.hasPrevious ? "" : "disabled")}>
                        <Link href={firstPage} className="page-link">
                            First
                        </Link>
                    </li>

                    <li className={"page-item " + (tricks.hasPrevious ? "" : "disabled")}>
                        <Link href={previousPage} className="page-link">
                            Previous
                        </Link>
                    </li>

                    <li className={"page-item " + (tricks.hasNext ? "" : "disabled")}>
                        <Link href={nextPage} className="page-link">
                            Next
                        </Link>
                    </li>

                    <li className={"page-item " + (tricks.hasNext ? "" : "disabled")}>
                        <Link href={lastPage} className="page-link">
                            Last
                        </Link>
                    </li>

                </ul>
            </nav>

        </div>
    );
}

export default Pagination;
