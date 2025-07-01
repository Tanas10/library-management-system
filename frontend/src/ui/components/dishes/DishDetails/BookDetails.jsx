import React from 'react';
import {useNavigate, useParams} from "react-router";
import {
    Box,
    Button,
    CircularProgress,
    Typography,
    Paper,
    Stack,
    Chip,
    Breadcrumbs,
    Link
} from "@mui/material";
import {
    ArrowBack, Person,
    Restaurant,
    ShoppingCart
} from "@mui/icons-material";
import useBookDetails from "../../../../hooks/useBookDetails.js";

const BookDetails = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const book = useBookDetails(id);

    if (!book) {
        return (
            <Box sx={{display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '60vh'}}>
                <CircularProgress/>
            </Box>
        );
    }


    return (
        <Box width={750} mx="auto" mt={3}>
            <Breadcrumbs aria-label="breadcrumb" sx={{mb: 3}}>
                <Link
                    underline="hover"
                    color="inherit"
                    href="#"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate("/book");
                    }}
                >
                    Books
                </Link>
                <Typography color="text.primary">{book.title}</Typography>
            </Breadcrumbs>

            <Paper elevation={2} sx={{p: 4, borderRadius: 4}}>
                <Stack spacing={3}>
                    <Typography variant="h4" fontWeight={600} className="dish-name">
                        {book.title}
                    </Typography>

                    <Typography variant="body1" color="text.secondary" className="dish-desc">
                        {book.genre || "No description provided."}
                    </Typography>

                    <Typography variant="h5" color="primary.main" className="dish-price">
                        {book.year}
                    </Typography>



                    <Chip
                        icon={<Person />}
                        label={book.author.name}
                        className="author-name"
                        color="secondary"
                        variant="outlined"
                        sx={{width: "fit-content", p: 2}}
                    />

                    <Stack direction="row" justifyContent="space-between" spacing={2} mt={2}>
                        <Button
                            variant="contained"
                            color="primary"
                            startIcon={<ShoppingCart />}
                            onClick={() => navigate(`/borrow-book/${book.id}`)}
                        >
                            Borrow Book
                        </Button>
                        <Button
                            variant="outlined"
                            startIcon={<ArrowBack />}
                            onClick={() => navigate("/books")}
                        >
                            Back to books
                        </Button>
                    </Stack>
                </Stack>
            </Paper>
        </Box>
    );
};

export default BookDetails;
