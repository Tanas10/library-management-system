import {useCallback, useEffect, useState} from "react";
import booksRepository from "../repository/bookRepository.js";

const initialState = {
    books: [],
    loading: true,
};

const useBooks = () => {
    const [state, setState] = useState(initialState);


    const fetchBooks  = useCallback(() => {
        setState(initialState);
        booksRepository
            .findAll()
            .then((response) => {
                setState({
                    "books": response.data,
                    "loading": false,
                });
            })
            .catch((error) => console.log(error));
    }, []);
    const onAdd = useCallback((data) => {
        booksRepository
            .add(data)
            .then(() => {
                console.log("Successfully added a new author.");
                fetchBooks();
            })
            .catch((error) => console.log(error));
    }, [fetchBooks]);



    // TODO: Implement this.
    const onDelete= useCallback((id) => {
        booksRepository
            .delete(id)
            .then(() => {
                console.log(`Successfully deleted the product with ID ${id}.`);
                fetchBooks();
            })
            .catch((error) => console.log(error));
    }, [fetchBooks]);

    useEffect(() => {
        fetchBooks()
    }, [fetchBooks]);

    return {...state, onAdd, onDelete};
};

export default useBooks;