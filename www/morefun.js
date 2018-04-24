var exec = require('cordova/exec');

exports.ServiceLoding = function (success, error) {
    exec(success, error, 'morefun', 'ServiceLoding', []);
};
exports.print_setGray = function (i,success, error) {
    exec(success, error, 'morefun', 'print_setGray', [i]);
};

exports.print_setFont = function (i,success, error) {
    exec(success, error, 'morefun', 'print_setFont', [i]);
};
exports.print_setFontSize = function (i,success, error) {
    exec(success, error, 'morefun', 'print_setFontSize', [i]);
};

exports.print_setFontWidth = function (i,success, error) {
    exec(success, error, 'morefun', 'print_setFontWidth', [i]);
};
exports.print_setXSpace = function (i,success, error) {
    exec(success, error, 'morefun', 'print_setXSpace', [i]);
};
exports.print_setYSpace = function (i,success, error) {
    exec(success, error, 'morefun', 'print_setYSpace', [i]);
};

exports.print_setLeftSpace = function (i,success, error) {
    exec(success, error, 'morefun', 'print_setLeftSpace', [i]);
};

exports.print_feedline = function (i,success, error) {
    exec(success, error, 'morefun', 'print_feedline', [i]);
};

exports.print_writeToBuffer = function (s,success, error) {
    exec(success, error, 'morefun', 'print_writeToBuffer', [s]);
};

exports.print_printText = function (s,success, error) {
    exec(success, error, 'morefun', 'print_printText', [s]);
};

exports.print_printBarCode = function (s,success, error) {
    exec(success, error, 'morefun', 'print_printBarCode', [s]);
};

exports.print_printQrCode = function (offset,content,height,success, error) {
    exec(success, error, 'morefun', 'print_printQrCode', [offset,content,height]);
};
exports.print_setBatchPrint = function (b, success, error) {
  exec(success, error, 'morefun', 'print_setBatchPrint', [b]);
};
exports.print_batchPrint = function (success, error) {
  exec(success, error, 'morefun', 'print_batchPrint', []);
};
