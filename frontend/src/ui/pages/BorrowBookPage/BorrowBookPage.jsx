import React, { useState } from 'react';
import { useNavigate, useParams } from 'react-router';
import {
    Box,
    Button,
    Typography,
    Paper,
    Stack,
    Select,
    MenuItem,
    InputLabel,
    FormControl,
    CircularProgress
} from '@mui/material';
import useBorrowrecords from "../../../hooks/useBorrowrecords.js";
import useUsers from "../../../hooks/useUsers.js";



const BorrowBookPage = () => {
    const navigate = useNavigate();
    const { id: bookId } = useParams();
    const [userId, setUserId] = useState('');
    const { onAdd } = useBorrowrecords(); // Use your hook's add function
    const { users, loading: usersLoading } = useUsers();


    const handleBorrow = async () => {
        const payload = {
            bookId: parseInt(bookId),
            userId: parseInt(userId),
            borrowDate: new Date().toISOString().split('T')[0],
            returnDate: new Date(Date.now() + 14 * 24 * 60 * 60 * 1000).toISOString().split('T')[0],
        };

        try {
            await onAdd(payload);
            navigate('/borrowed-records');
        } catch (error) {
            console.error("Borrow failed:", error);
            alert("Failed to borrow book. Please try again.");
        }
    };

    return (
        <Box width={750} mx="auto" mt={3}>
            <Paper elevation={2} sx={{ p: 4, borderRadius: 4 }}>
                <Stack spacing={3}>
                    <Typography variant="h4" fontWeight={600}>
                        Borrow Book
                    </Typography>

                    {/* User Dropdown */}
                    <FormControl fullWidth>
                        <InputLabel id="user-select-label">User</InputLabel>
                        <Select
                            labelId="user-select-label"
                            label="User"
                            value={userId}
                            onChange={(e) => setUserId(e.target.value)}
                            disabled={usersLoading}
                            MenuProps={{ PaperProps: { style: { maxHeight: 300 } } }}
                        >
                            {users.map((user) => (
                                <MenuItem key={user.id} value={user.id}>
                                    {user.fullName}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>

                    <Stack direction="row" spacing={2}>
                        <Button
                            variant="contained"
                            onClick={handleBorrow}
                            disabled={!userId || usersLoading}
                        >
                            Confirm Borrow
                        </Button>
                        <Button
                            variant="outlined"
                            onClick={() => navigate(`/books/${bookId}`)}
                        >
                            Cancel
                        </Button>
                    </Stack>
                </Stack>
            </Paper>
        </Box>
    );
};

export default BorrowBookPage;