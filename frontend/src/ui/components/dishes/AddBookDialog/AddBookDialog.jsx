import React, {useState} from 'react';
import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle,
    FormControl,
    InputLabel, MenuItem, Select,
    TextField
} from "@mui/material";
import useAuthors from "../../../../hooks/useAuthors.js";


const initialFormData = {
    "title": "",
    "year": "",
    "genre": "",
    "authorId": "",
};

const AddBookDialog = ({open, onClose, onAdd}) => {
    const [formData, setFormData] = useState(initialFormData);
    // const authors = useAuthors();
    const {authors} = useAuthors()

    // TODO: Implement this.
    const handleChange = (event) => {
        const {name, value} = event.target;
        setFormData({...formData, [name]: value});
    };

    const handleSubmit = () => {
        onAdd(formData);
        setFormData(initialFormData);
        onClose();
    };
    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Add Book</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    label="Title"
                    name="title"
                    value={formData.title}
                    onChange={handleChange}
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="Year"
                    name="year"
                    type="number"
                    fullWidth
                    value={formData.year}
                    onChange={handleChange}
                />
                <TextField
                    margin="dense"
                    label="Genre"
                    name="genre"
                    fullWidth
                    value={formData.genre}
                    onChange={handleChange}
                />

                <FormControl fullWidth margin="dense">
                    <InputLabel>Author</InputLabel>
                    <Select
                        name="authorId"
                        label="Author"
                        variant="outlined"
                        className="author-select"
                        value={formData.authorId}
                        onChange={handleChange}
                        MenuProps={{PaperProps: {style: {maxHeight: 100}}}}>
                        {authors.map((author) => (
                            <MenuItem
                                key={author.id}
                                value={author.id}
                                className="author-option"
                            >
                                {author.name} {author.country}
                            </MenuItem>
                        ))}

                    </Select>
                </FormControl>
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button variant="contained" color="primary" className="submit-btn" onClick={handleSubmit}>Add</Button>
            </DialogActions>
        </Dialog>
    );
};

export default AddBookDialog;