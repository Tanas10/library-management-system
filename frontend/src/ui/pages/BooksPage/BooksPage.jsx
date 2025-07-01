import React, {useState} from 'react';
import {Box, Button, CircularProgress} from "@mui/material";
import "./BooksPage.css";
import BooksGrid from "../../components/dishes/DishesGrid/BooksGrid.jsx";
import AddBookDialog from "../../components/dishes/AddBookDialog/AddBookDialog.jsx";
import useBooks from "../../../hooks/useBooks.js";

const BooksPage = () => {
    const {books, loading, onAdd, onDelete} = useBooks();

    const [addDishDialogOpen, setAddDishDialogOpen] = useState(false);

    return (
        <>
            <Box className="dishes-box">
                <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                    <Button
                        variant="contained"
                        color="primary"
                        onClick={() => setAddDishDialogOpen(true)}
                        className="add-item"
                    >
                        Add Book
                    </Button>
                </Box>
                {loading && <Box className="progress-box"><CircularProgress/></Box>}
                {!loading && <BooksGrid books={books}  onDelete={onDelete}/>}
            </Box>
            <AddBookDialog
                open={addDishDialogOpen}
                onClose={() => setAddDishDialogOpen(false)}
                onAdd={onAdd}
            />
        </>
    );
};

export default BooksPage;