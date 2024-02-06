import axios from "axios";
import {TricksResponse} from "./models";
import getConfig from 'next/config';
const { serverRuntimeConfig, publicRuntimeConfig } = getConfig();

const getApiUrl = () => {
    return serverRuntimeConfig.API_BASE_URL || publicRuntimeConfig.API_BASE_URL;
}

export const fetchTricks = async (page: number, query: string): Promise<TricksResponse> => {
    let url = `${getApiUrl()}/api/tricks?page=${page}`;
    if(query) {
        url += `&query=${query}`;
    }
    const res = await axios.get<TricksResponse>(url);
    return res.data;
}

export const saveTrick = async (trick:{name: string, difficulty: string}) => {
    const res = await axios.post(`${getApiUrl()}/api/tricks`, trick);
    return res.data;
}
