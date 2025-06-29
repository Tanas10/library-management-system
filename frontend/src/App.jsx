import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router";
import Layout from "./ui/components/layout/Layout/Layout.jsx";
import HomePage from "./ui/pages/HomePage/HomePage.jsx";

import DishDetails from "./ui/components/dishes/DishDetails/DishDetails.jsx";


import OrderList from "./ui/components/order/OrderList/OrderList.jsx";
import BooksPage from "./ui/pages/BooksPage/BooksPage.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout/>}>
                    <Route index element={<HomePage/>}/>
                        <Route path="books" element={<BooksPage/>}/>
                        <Route path="books/:id" element={<DishDetails/>}/>
                        <Route path="/borrow-records" element={<OrderList/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;