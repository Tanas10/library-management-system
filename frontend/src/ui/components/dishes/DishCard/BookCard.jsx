import React, {useState} from 'react';
import InfoIcon from '@mui/icons-material/Info';
import DeleteIcon from '@mui/icons-material/Delete';
import {Card, CardContent, Typography, CardActions, Button, Box} from '@mui/material';
import {useNavigate} from "react-router";
import DeleteBookDialog from "../DeleteBookDialog/DeleteBookDialog.jsx";

const BookCard = ({book, onDelete}) => {
    const navigate = useNavigate();

    const [deleteDishDialogOpen, setDeleteDishDialogOpen] = useState(false);

    return (
        <>
            <Card
                sx={{
                    borderRadius: 2,
                    p: 1,
                    flexGrow: 1,
                    display: "flex",
                    flexDirection: "column",
                    justifyContent: "space-between"
                }}
                className="card"
                data-id={book.id}
            >
                <CardContent sx={{pb: 0}}>
                    <Typography gutterBottom variant="h5" component="div" className="dish-name">
                        Title: {book.title}
                    </Typography>
                    <Typography variant="body2" color="text.secondary" sx={{mb: 1.5}}  className="dish-desc">
                        Genre: {book.genre}
                    </Typography>
                    <Box display="flex" justifyContent="space-between" alignItems="center">
                        <Typography variant="body1" sx={{fontWeight: 'bold'}}>
                            Year: {book.year}
                        </Typography>
                    </Box>
                </CardContent>
                <CardActions sx={{justifyContent: "space-between"}}>
                    <Button
                        size="small"
                        color="info"
                        startIcon={<InfoIcon/>}
                        onClick={() => navigate(`/books/${book.id}`)}
                        className="info-item"
                    >
                        Info
                    </Button>
                    <Box>
                        <Button
                            size="small"
                            color="error"
                            startIcon={<DeleteIcon/>}
                            onClick={() => setDeleteDishDialogOpen(true)}
                            className="delete-item"
                        >
                            Delete
                        </Button>
                    </Box>
                </CardActions>
            </Card>

            <DeleteBookDialog
                open={deleteDishDialogOpen}
                onClose={() => setDeleteDishDialogOpen(false)}
                onDelete={onDelete}
                book={book}
            />
        </>
    );
};

export default BookCard;