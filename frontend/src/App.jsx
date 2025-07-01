import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router";
import Layout from "./ui/components/layout/Layout/Layout.jsx";
import HomePage from "./ui/pages/HomePage/HomePage.jsx";

import BookDetails from "./ui/components/dishes/DishDetails/BookDetails.jsx";


import BooksPage from "./ui/pages/BooksPage/BooksPage.jsx";
import BorrowBookPage from "./ui/pages/BorrowBookPage/BorrowBookPage.jsx";
import BorrowedRecordsPage from "./ui/pages/BorrowedRecordsPage/BorrowedRecordsPage.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout/>}>
                    <Route index element={<HomePage/>}/>
                        <Route path="books" element={<BooksPage/>}/>
                        <Route path="books/:id" element={<BookDetails/>}/>
                     <Route path="/borrow-book/:id" element={<BorrowBookPage />} />
                    <Route path="/borrowed-records" element={<BorrowedRecordsPage />} /></Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;