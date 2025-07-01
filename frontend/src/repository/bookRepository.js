import axiosInstance from "../axios/axios.js";

const bookRepository = {
    findAll: async () => {
        return await axiosInstance.get("/books");
    },
    find: async (id) => {
        return await axiosInstance.get(`/books/${id}`);
    },
    add: async (data) => {
        return await axiosInstance.post("/books", data);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/books/${id}`);
    }
};

export default bookRepository;