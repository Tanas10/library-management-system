import axiosInstance from "../axios/axios.js";

const userRepository = {
    findAll: async () => {
        return await axiosInstance.get("/users");
    },
    find: async (id) => {
        return await axiosInstance.get(`/users/${id}`);
    },
    add: async (data) => {
        return await axiosInstance.post("/users", data);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/users/${id}`);
    }
};

export default userRepository;