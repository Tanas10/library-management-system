import {useCallback, useEffect, useState} from "react";
import borrowrecordRepository from "../repository/borrowrecordRepository.js";

const initialState = {
    borrowrecords: [],
    loading: true,
};

const useBorrowrecords = () => {
    const [state, setState] = useState(initialState);


    const fetchBorrowrecords = useCallback(() => {
        setState(initialState);
        borrowrecordRepository.findAll()
            .then((response) => {
                const recordsWithDetails = response.data.map(record => ({
                    ...record,
                    book: record.book || {},
                    user: record.user || {},
                }));
                setState({
                    borrowrecords: recordsWithDetails,
                    loading: false,
                });
            })
            .catch((error) => console.log(error));
    }, []);

    const onAdd = useCallback(async (data) => {
        try {
            const response = await borrowrecordRepository.add(data);
            setState(prev => ({
                ...prev,
                borrowrecords: [...prev.borrowrecords, response.data], // Add new record to state
                loading: false,
            }));
            console.log("Successfully added a new borrow record:", response.data);
            return response.data;
        } catch (error) {
            console.error("Add failed:", error);
            throw error;
        }
    }, []);



    // TODO: Implement this.
    const onDelete= useCallback((id) => {
        borrowrecordRepository
            .delete(id)
            .then(() => {
                console.log(`Successfully deleted the product with ID ${id}.`);
                fetchBorrowrecords();
            })
            .catch((error) => console.log(error));
    }, [fetchBorrowrecords]);

    useEffect(() => {
        fetchBorrowrecords()
    }, [fetchBorrowrecords]);

    return {...state, onAdd, onDelete};
};

export default useBorrowrecords;