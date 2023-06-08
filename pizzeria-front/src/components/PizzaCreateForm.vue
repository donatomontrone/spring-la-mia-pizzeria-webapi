<template>
    <div>
        <h2>Create a Pizza</h2>
        <form @submit.prevent="create">
            <label for="name">Nome</label><br>
            <input type="text" name="name" v-model="pizza.name">
            <br>
            <label for="description">Descrizione</label><br>
            <input type="text" name="description" v-model="pizza.description">
            <br>
            <label for="path">Url Immagine</label><br>
            <input type="text" name="imgPath" v-model="pizza.imgPath">
            <br>
            <label for="price">Prezzo</label><br>
            <input type="number" name="price" v-model="pizza.price">
            <br>
            <button type="submit">Invia</button>
        </form>
    </div>
</template>
<script>
import axios from "axios";
const API_URL = "http://localhost:8080/api/v1";
export default {
    data() {
        return {
            pizza: {
                name: "",
                description: "",
                imgPath: "",
                price: 0,
            }
        }
    },
    methods: {
        create() {
            axios.post(API_URL + "/pizzas/create", this.pizza)
                .then((response) => {
                    this.$router.push('/');
                })
        }
    },
}
</script>
<style lang="scss" scoped></style>