import axiosInstance from "../axios/axios.js";

const authorRepository = {
    findAll: async () => {
        return await axiosInstance.get("/authors");
    },
    find: async (id) => {
        return await axiosInstance.get(`/authors/${id}`);
    },
    add: async (data) => {
        return await axiosInstance.post("/authors", data);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/authors/${id}`);
    }
};

export default authorRepository;