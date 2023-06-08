<template>
    <router-link to="/pizzas/create">Aggiungi una pizza</router-link>
    <PizzaContainer />
</template>
<script>
import PizzaContainer from '../components/PizzaContainer.vue';
export default {
    components: { PizzaContainer }
}
</script>
<style lang="scss"></style>