import axiosInstance from "../axios/axios.js";

const borrowrecordRepository = {
    findAll: async () => {
        return await axiosInstance.get("/borrow-records");
    },
    find: async (id) => {
        return await axiosInstance.get(`/borrow-records/${id}`);
    },
    add: async (data) => {
        return await axiosInstance.post("/borrow-records", data)
            .then(response => response.data);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/borrow-records/${id}`);
    }
};

export default borrowrecordRepository;