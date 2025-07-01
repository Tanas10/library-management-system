import {useCallback, useEffect, useState} from "react";
import userRepository from "../repository/userRepository.js";

const initialState = {
    users: [],
    loading: true,
};

const useUsers = () => {
    const [state, setState] = useState(initialState);


    const fetchAuthors  = useCallback(() => {
        setState(initialState);
        userRepository
            .findAll()
            .then((response) => {
                setState({
                    "users": response.data,
                    "loading": false,
                });
            })
            .catch((error) => console.log(error));
    }, []);
    const onAdd = useCallback((data) => {
        userRepository
            .add(data)
            .then(() => {
                console.log("Successfully added a new author.");
                fetchAuthors();
            })
            .catch((error) => console.log(error));
    }, [fetchAuthors]);



    // TODO: Implement this.
    const onDelete= useCallback((id) => {
        userRepository
            .delete(id)
            .then(() => {
                console.log(`Successfully deleted the product with ID ${id}.`);
                fetchAuthors();
            })
            .catch((error) => console.log(error));
    }, [fetchAuthors]);

    useEffect(() => {
        fetchAuthors()
    }, [fetchAuthors]);

    return {...state, onAdd, onDelete};
};

export default useUsers;