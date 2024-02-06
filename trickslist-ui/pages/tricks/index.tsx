import type {GetServerSideProps, NextPage} from 'next'
import {TricksResponse} from "../../services/models";
import {fetchTricks} from "../../services/api";
import Tricks from "../../components/Tricks";
import SearchForm from "../../components/SearchForm";

interface HomeProps {
    tricks: TricksResponse
    query?: string
}
const Home: NextPage<HomeProps> = (props) => {
    return (
        <div>
            <SearchForm/>
            <Tricks tricks={props.tricks} query={props.query}/>
        </div>
    )
}

export const getServerSideProps: GetServerSideProps = async (context) => {
    const {page = 1, query = "" } = context.query
    const tricks = await fetchTricks(parseInt(String(page)), String(query))
    return {
        props: {
            tricks,
            query
        }
    }
}

export default Home
