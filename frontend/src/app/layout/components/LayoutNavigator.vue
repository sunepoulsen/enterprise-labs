<template>
    <div id="nav">
        <Panel header="Links">
            <ul>
                <li><router-link to="/">Home</router-link></li>
                <li><router-link to="/about">About</router-link></li>
            </ul>
        </Panel>
    </div>
</template>

<script lang="ts">
export default {
  name: 'LayoutNavigator'
}
</script>

<style scoped lang="scss">
    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        //display: inline-block;
        margin: 0 10px;
    }
</style>
