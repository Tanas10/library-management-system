import {useEffect, useState} from "react";
import bookRepository from "../repository/bookRepository.js";

const useBookDetails = (id) => {
    const [book, setBook] = useState(null);

    useEffect(() => {
        bookRepository
            .find(id)
            .then((response) => setBook(response.data))
            .catch((error) => console.log(error));
    }, [id]);

    return book;
};

export default useBookDetails;