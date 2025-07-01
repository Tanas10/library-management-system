import React from 'react';
import {
    Box,
    Typography,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    TablePagination,
    Button,
    Stack
} from '@mui/material';
import useBorrowrecords from "../../../hooks/useBorrowrecords.js";
import {useNavigate} from "react-router";


const BorrowedRecordsPage = () => {
    const navigate = useNavigate();
    const { borrowrecords, loading } = useBorrowrecords();
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(10);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };

    if (loading) {
        return (
            <Box sx={{ display: 'flex', justifyContent: 'center', mt: 4 }}>
                <Typography>Loading borrowed records...</Typography>
            </Box>
        );
    }

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" gutterBottom>
                Borrowed Records
            </Typography>

            <Paper elevation={3}>
                <TableContainer>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell>ID</TableCell>
                                <TableCell>Book</TableCell>
                                <TableCell>Borrowed By</TableCell>
                                <TableCell>Borrow Date</TableCell>
                                <TableCell>Return Date</TableCell>
                                <TableCell>Actions</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {borrowrecords
                                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                                .map((record) => (
                                    <TableRow key={record.id}>
                                        <TableCell>{record.id}</TableCell>
                                        <TableCell>
                                            {record.book?.title || 'Unknown'}
                                        </TableCell>
                                        <TableCell>
                                            {record.user?.fullName || 'Unknown'}
                                        </TableCell>
                                        <TableCell>{record.borrowDate}</TableCell>
                                        <TableCell>{record.returnDate}</TableCell>
                                        <TableCell>
                                            <Button
                                                variant="outlined"
                                                size="small"
                                                onClick={() => navigate(`/books/${record.book?.id}`)}
                                            >
                                                View Book
                                            </Button>
                                        </TableCell>
                                    </TableRow>
                                ))}
                        </TableBody>
                    </Table>
                </TableContainer>
                <TablePagination
                    rowsPerPageOptions={[5, 10, 25]}
                    component="div"
                    count={borrowrecords.length}
                    rowsPerPage={rowsPerPage}
                    page={page}
                    onPageChange={handleChangePage}
                    onRowsPerPageChange={handleChangeRowsPerPage}
                />
            </Paper>

            <Stack direction="row" spacing={2} sx={{ mt: 2 }}>
                <Button
                    variant="contained"
                    onClick={() => navigate('/books')}
                >
                    Back to Books
                </Button>
            </Stack>
        </Box>
    );
};

export default BorrowedRecordsPage;