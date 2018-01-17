var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http, $filter) {
    var orderBy = $filter('orderBy');
    $scope.clients = [{
        name: 'Steven',
        designation: 'Database Administrator',
        company: {
            id: 3,
            name: 'Google'
        },
        rating: 100,
        action: 'false'
    }, {
        name: 'Jim',
        designation: 'Designer',
        company: {
            id: 2,
            name: 'Facebook'
        },
        rating: 500,
        action: 'true'
    }, {
        name: 'Michael',
        designation: 'Front-End Developer',
        company: {
            id: 1,
            name: 'Apple'
        },
        rating: 50,
        action: 'true'
    }, {
        name: 'Josh',
        designation: 'Network Engineer',
        company: {
            id: 3,
            name: 'Google'
        },
        rating: 100,
        action: 'true'
    }, {
        name: 'Ellie',
        designation: 'Internet Marketing Engineer',
        company: {
            id: 1,
            name: 'Apple'
        },
        rating: 1000,
        action: 'true'
    }];
    $scope.order = function(predicate) {
        $scope.predicate = predicate;
        $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
        $scope.friends = orderBy($scope.friends, predicate, $scope.reverse);
    };
    $scope.i = 0;
    $scope.greaterThan = function(prop) {
        return function(item) {
            var minrating = $scope.minrating;
            if (minrating == undefined) minrating = 0;
            if (item[prop] * 1 >= minrating * 1) return true;
        }
    }
    $scope.pagelimit = 3;
    $scope.sstart = 0;
    $scope.endReach = false;
    $scope.startReach = true;
    $scope.next = function($event) {
        $scope.sstart += $scope.pagelimit;
        $scope.startReach = false;
        if (($scope.sstart + $scope.pagelimit) > $scope.clients.length - 1) {
            $scope.endReach = true;
        }
    };
    $scope.prev = function($event) {
        $scope.sstart -= $scope.pagelimit;
        $scope.endReach = false;
        if ($scope.sstart == 0) {
            $scope.startReach = true;
        }
    };
    $scope.pagestart = 1;
    angular.forEach($scope.clients.length, function() {
        $scope.vgrg = angular.fromJson($(".cont").eq($scope.i).val());
        $scope.clients.push($scope.vgrg);
        $scope.i++;
    });

    $scope.saveChange = function($event, item, element) {
        if ($event.currentTarget.type == "checkbox")
            item[element] = $event.currentTarget.checked;
        else
        if (element.indexOf(".") > -1) {
            element = element.split(".")[0] + "[" + element.split(".")[1] + "]";
            item.element = $event.currentTarget.value;
            item.company["name"] = item.element;
        } else
            item[element] = $event.currentTarget.value;
        //item[element]=$scope.obj;
    };
    $scope.addEmployeefunc = function() {
        if ($scope.addEmployee != undefined && $scope.addEmployee.length > 3) {
            if ($scope.addEmployee.action == undefined)
                $scope.addEmployee.action = "false";
            $scope.clients.push($scope.addEmployee);
            $scope.addEmployee = [];
        } else
            alert("Enter minimal information");
    }
    $scope.resetFilter = function() {
        $scope.searchtest = [];
        $scope.minrating = "";
    }
});

$(document).ready(function() {
    var prevValues = [];
    $(document).delegate(".edit", "click", function() {
        prevValues = [];
        var trEle = $(this).closest("tr");
        trEle.find(".editers").removeClass("hidden");
        trEle.find(".labelValues").addClass("hidden");
        trEle.find(".save, .cancel").removeClass("hidden");
        $(this).addClass("hidden");
        trEle.find(".editers").each(function() {
            if ($(this)[0].type == "checkbox")
                prevValues.push($(this)[0].checked);
            else
                prevValues.push($(this).val());
        });
        $(".edit").attr("disabled", true);
    });
    $(document).delegate(".cancel", "click", function() {
        var trEle = $(this).closest("tr");
        trEle.find(".editers").addClass("hidden");
        trEle.find(".labelValues").removeClass("hidden");
        trEle.find(".save, .cancel").addClass("hidden");
        trEle.find(".edit").removeClass("hidden");
        for (var i = 0; i < prevValues.length; i++) {
            trEle.find(".editers").eq(i).val(prevValues[i]).click();
            if (trEle.find(".editers").eq(i)[0].type == "checkbox" && trEle.find(".editers").eq(i)[0].checked != prevValues[i])
                trEle.find(".editers").eq(i).click();
        }
        $(".edit").attr("disabled", false);
    });
    $(document).delegate(".save", "click", function() {
        var trEle = $(this).closest("tr");
        trEle.find(".editers").addClass("hidden");
        trEle.find(".labelValues").removeClass("hidden");
        trEle.find(".save, .cancel").addClass("hidden");
        trEle.find(".edit").removeClass("hidden");
        for (var i = 0; i < trEle.find(".editers").length; i++) {
            if (trEle.find(".editers").eq(i)[0].type != "checkbox")
                trEle.find(".editers").eq(i).click();
        }
        $(".edit").attr("disabled", false);
    });
});

$(document).ready(function() {
    $(".nav-tabs a").click(function() {
        $(this).tab('show');
    });
    $('.nav-tabs a').on('shown.bs.tab', function(event) {
        var x = $(event.target).text(); // active tab
        var y = $(event.relatedTarget).text(); // previous tab
        $(".act span").text(x);
        $(".prev span").text(y);
    });
});