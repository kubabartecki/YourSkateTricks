
export interface TricksResponse {
    data: Trick[],
    totalElements: number,
    currentPage: number,
    totalPages: number,
    isFirst: boolean,
    isLast: boolean,
    hasNext: boolean,
    hasPrevious: boolean
}

export interface Trick {
    id: number,
    name: string,
    difficulty: string
}
