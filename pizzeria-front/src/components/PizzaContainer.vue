<template>
    <div class="container">
        <div class="row">
            <div class="col-6">
                <input type="text" class="form-control" v-model="name" @keyup="getPizzas"> <button
                    class="btn btn-outline-dark" @click="getPizzas">Cerca</button>
            </div>
        </div>
    </div>
    <div v-if="isEmpty">{{ message }}</div>
    <div v-else v-for="pizza in pizzas"> {{ pizza.name }} </div>
</template>
<script>
import axios from "axios";
const API_URL = "http://localhost:8080/api/v1";
export default {
    data() {
        return {
            pizzas: [],
            message: "",
            isEmpty: true,
            name: "",
        }
    },
    methods: {
        getPizzas() {
            axios
                .get(API_URL + "/pizzas", {
                    params: {
                        name: this.name
                    }
                })
                .then((response) => {
                    if (response.status = 200) {
                        console.log(response.data)
                        if (response.data.length === 0) {
                            this.message = "Nessuna pizzeria trovata."
                            this.isEmpty = true
                        } else {
                            this.isEmpty = false;
                            this.pizzas = response.data;
                            this.message = "";
                        }
                    }
                })
                .catch((error) => {
                    console.log(error)
                })

        }
    },
    mounted() {
        this.getPizzas()
    },
}
</script>
<style lang="">
    
</style>