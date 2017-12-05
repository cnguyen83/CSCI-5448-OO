$(() => {
    function addItem()
    {
        var menuItemsInput = $('#menuItemsInput');
        var numMenuItems = menuItemsInput.children().length;

        menuItemsInput.append(
            '<div>' +
               '<input type="hidden" th:field="${menu.menuItems[].key}" />' +
               '<div class="form-group">' +
                   '<label>Item Name</label>' +
                   '<input type="text" class="form-control" name="menuItems[' + numMenuItems +  '].name" ' +
                        'id="menuItems' + numMenuItems + '".name />' +
               '</div>' +
               '<div class="form-group">' +
                   '<label>Item Description</label>' +
                   '<input type="text" class="form-control" name="menuItems[' + numMenuItems +  '].description" ' +
                        'id="menuItems' + numMenuItems + '".description />' +
               '</div>' +
               '<div class="form-group">' +
                   '<label>Item Cost</label>' +
                   '<input type="text" class="form-control" name="menuItems[' + numMenuItems +  '].cost" ' +
                        'id="menuItems' + numMenuItems + '".cost />' +
               '</div>' +
           '</div>');
    }

    $('#addItemButton').on('click', addItem);
});